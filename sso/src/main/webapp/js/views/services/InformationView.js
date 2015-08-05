define([
        'jquery',
        'underscore',
        'backbone',
        'text!templates/services/information.html',
        'models/Session',
        'router',
        'jqueryui'
], function($, _, Backbone, view_template, Session, Routeur){
	
	var PageView = Backbone.View.extend({
		
		initialize: function(){
		},
		
		events: {
	        "click .home"   : "click_home"
	    },
	    
		render: function(){
			var template_options = {};
			this.template = _.template(view_template, template_options);
			var new_view = this.$el.html(this.template(Session.get('user')));
			
			return new_view;
		},
	    
	    click_home: function(event){
	    	Backbone.history.navigate("");
	    }
	});
		
	return PageView;
});