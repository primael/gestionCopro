//https://github.com/jjbskir/backbone-single-page-client-side-auth/blob/master/public/js/router.js


define([
        'jquery',
        'underscore',
        'backbone',
        'src/Page',
        'src/Permissions',
        'views/DefaultView',
        'models/Session'       
], function($, _, Backbone, Page, Permissions, DefaultView, Session){
	
	var AppRouter = Backbone.Router.extend({
		//define the route and function maps for this router
		routes: {
			"": "home",
			"login": "login"
		},
		
		route_permissions: {
			"": Permissions.public
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
			console.log(Session);
			console.log(user);
			if(!Permissions.validate(route, permission) && permission != Permissions.user){
				this.navigate('login', {trigger: true});
				return false;
			}
			//else direct then another area.
			return true;
		}
	})
});