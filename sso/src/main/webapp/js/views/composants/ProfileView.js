define([
        'jquery',
        'underscore',
        'backbone',
        'text!templates/composants/profil.html',
        'models/Session',
        'jqueryui'
], function($, _, Backbone, view_template, Session){
	
	var PageView = Backbone.View.extend({
		
		initialize: function(){
		},
		
		events: {
	        "click .deconnexion"   : "click_deconnexion",
	        "click .account"       : "click_account"
	        	
	    },
	    		
		render: function(){
			var template_options = {};
			this.template = _.template(view_template, template_options);
			var new_view = this.$el.html(this.template(Session.get('user')));
			
			return new_view;
		},
		
		click_deconnexion: function(event){
			Session.logout();
		},
		
		click_account: function(event){
			$('.sidebar-right').toggle('slide', {direction:'right'});
			window.location = '#information';
		}
	});
	
	return PageView;
});