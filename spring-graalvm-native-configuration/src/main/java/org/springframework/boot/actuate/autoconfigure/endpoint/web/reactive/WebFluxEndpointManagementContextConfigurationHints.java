/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.boot.actuate.autoconfigure.endpoint.web.reactive;

import org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.CommonWebActuatorTypes;
import org.springframework.nativex.extension.NativeImageConfiguration;
import org.springframework.nativex.extension.NativeImageHint;
import org.springframework.nativex.extension.TypeInfo;
import org.springframework.nativex.type.AccessBits;
import org.springframework.nativex.type.TypeSystem;


@NativeImageHint(trigger=WebFluxEndpointManagementContextConfiguration.class,
	importInfos = { CommonWebActuatorTypes.class},
	typeInfos = {
	@TypeInfo(
//			types = {
//		AbstractWebFluxEndpointHandlerMapping.class,
//		ControllerEndpointHandlerMapping.class,
//		DefaultWebClientExchangeTagsProvider.class,
//		WebClientExchangeTagsProvider.class,
//		MetricsWebFilter.class,
//		DefaultWebFluxTagsProvider.class,
//		WebFluxTagsProvider.class,
//		MetricsWebClientCustomizer.class
//	}, 
			typeNames = {
//		"org.springframework.boot.actuate.endpoint.web.reactive.ControllerEndpointHandlerMapping",
//		"org.springframework.boot.actuate.endpoint.web.reactive.AbstractWebFluxEndpointHandlerMapping",
		"org.springframework.boot.actuate.endpoint.web.reactive.WebFluxEndpointHandlerMapping$WebFluxLinksHandler",
		"org.springframework.boot.actuate.endpoint.web.reactive.AbstractWebFluxEndpointHandlerMapping$LinksHandler",
		"org.springframework.boot.actuate.endpoint.web.reactive.AbstractWebFluxEndpointHandlerMapping$ReadOperationHandler",
		"org.springframework.boot.actuate.autoconfigure.web.reactive.ReactiveManagementChildContextConfiguration",
		"org.springframework.boot.actuate.endpoint.web.reactive.AbstractWebFluxEndpointHandlerMapping$WriteOperationHandler",
		"org.springframework.boot.actuate.autoconfigure.web.reactive.ReactiveManagementContextFactory",
	}, access=AccessBits.LOAD_AND_CONSTRUCT|AccessBits.DECLARED_METHODS)
})
public class WebFluxEndpointManagementContextConfigurationHints implements NativeImageConfiguration {

	@Override
	public boolean isValid(TypeSystem typeSystem) {
		// Similar to check in OnWebApplicationCondition (effectively implementing ConditionalOnWebApplication(REACTIVE))
		boolean isWebfluxApplication = typeSystem.resolveName("org.springframework.web.reactive.HandlerResult", true) != null;
		return isWebfluxApplication;
	}

}