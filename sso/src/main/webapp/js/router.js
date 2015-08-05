//https://github.com/jjbskir/backbone-single-page-client-side-auth/blob/master/public/js/router.js


define([
        'jquery',
        'underscore',
        'backbone',
        'src/Page',
        'src/Permissions',
        'views/DefaultView',
        'views/user_account/LoginPageView',
        'views/HomeView',
        'views/composants/HeaderView',
        'views/composants/FooterView',
        'views/composants/ProfileView',
        'views/services/InformationView', 
        'models/Session',
        'backbone_router'
], function($, _, Backbone, Page, Permissions, DefaultView, LoginPageView, HomePageView, HeaderPageView, 
		FooterPageView, ProfilePageView, InformationPageView, Session){
	
	var AppRouter = Backbone.Router.extend({
		//define the route and function maps for this router
		routes: {
			"": "home",
			"home": "home",
			"login": "login",
			"information": "information"
		},
		
		route_permissions: {
			"login": Permissions.public
		},
		
		init: function(){},
		
		/**
		 * Before every url change, authenticate the routes.
		 */
		before: function(route){
			//dependent on what auth returns:
			return this.auth();
		},
		
		auth: function(){
			var route = Backbone.history.fragment;
			// if the user is permitted to view the route.
			var user = Session.get('user');
			var permission = user.permission;
			if(!Permissions.validate(route, permission) && permission != Permissions.user){
				this.navigate('login', {trigger: true});
				return false;
			}
			//else direct then another area.
			return true;
		},
		
		session_change: function(){
			var route = Backbone.history.fragment;
			//if the user has just logged in
			if(route != '' && Session.previous('auth') == false && Session.get('auth') == true) {
				//redirect to homepage
				//best to make this public page, in case it takes a second or 2 to update the model for some odd reason.
				this.navigate('', {trigger: true});
				return false;
			}
			//the user has just loggeed out.
			else if(Session.get('auth') == false){
				//redirect to login page.
				this.navigate('login', {trigger: true});
				return false;
			}
			
			return true;
		},
		
		initialize: function(){
			Permissions.init(this.routes, this.route_permissions);
			
			Session.getAuth(function() {
				Backbone.history.start();
				Session.bind('change:auth', app_router.session_change, app_router);
			});
		},
		
		login: function(data){
			Page.show(new LoginPageView({el: $('#content')}));
		},
		
		home: function(){
			var header = new HeaderPageView({el: $('.header'), template_name: 'composants/header'});
			header.render();
			
			var profile = new ProfilePageView({el: $('.sidebar-right'), template_name: 'composants/profil'});
			profile.render();
			
			var footer = new FooterPageView({el: $('.footer'), template_name: 'composants/footer'});
			footer.render();
			
			Page.show(new HomePageView({el: $('#content')}));
		},
		
		information: function(){
			var header = new HeaderPageView({el: $('.header'), template_name: 'composants/header'});
			header.render();
			
			var profile = new ProfilePageView({el: $('.sidebar-right'), template_name: 'composants/profil'});
			profile.render();
			
			var footer = new FooterPageView({el: $('.footer'), template_name: 'composants/footer'});
			footer.render();
			
			Page.show(new InformationPageView({el: $('#content')}));
		}
	});
	
	var app_router = new AppRouter();
	return app_router;
});