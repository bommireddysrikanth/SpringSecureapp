
package com.portal.procucev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Autowired
	CustomFilter filterreds;

	private static final String RESOURCE_ID = "resource_id";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
	http.addFilterBefore(filterreds, ChannelProcessingFilter.class).anonymous().disable().authorizeRequests()
	.antMatchers("/rest2/**").fullyAuthenticated().and().exceptionHandling()
	.accessDeniedHandler(new OAuth2AccessDeniedHandler()).and().headers().frameOptions().disable().and()
	.csrf().disable().headers()
	// the headers you want here. This solved all my CORS problems!
	.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"))
	.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Methods", "POST, GET"))
	.addHeaderWriter(new StaticHeadersWriter("Access-Control-Max-Age", "3600"))
	.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Credentials", "true"))
	.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers",
	"Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization"));
	};

}
