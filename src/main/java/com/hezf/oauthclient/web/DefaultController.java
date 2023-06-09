/*
 * Copyright 2020-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hezf.oauthclient.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Joe Grandja
 * @author Dmitriy Dubson
 * @since 0.0.1
 */
@Controller
public class DefaultController {

	@GetMapping("/")
	public String root() {
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String index(@AuthenticationPrincipal OAuth2User user, @AuthenticationPrincipal OidcUser oidcUser) {

		System.out.println("进入了 index");
		System.out.println(user.toString());
		System.out.println(user.getAttribute("sub").toString());
		System.out.println(user.getAttribute("myname").toString());

		System.out.println(oidcUser.getName());
		System.out.println(oidcUser.toString());

		return "index";
	}

	@GetMapping("/logged-out")
	public String loggedOut() {
		return "logged-out";
	}

	@GetMapping("/login/oauth2/code/messaging-client-oidcc")
	public String messagingClientOidcc(@RequestParam("code") String code, @RequestParam("state") String state) {
		System.out.println("code 和 state");
		System.out.println(code);
		System.out.println(state);
		return "redirect:/index";
	}

}
