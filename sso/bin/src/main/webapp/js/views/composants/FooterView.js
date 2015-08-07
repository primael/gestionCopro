define([
        'jquery',
        'underscore',
        'backbone',
        'text!templates/composants/footer.html',
        'models/Session',
        'jqueryui'
], function($, _, Backbone, view_template, Session){
	
	var PageView = Backbone.View.extend({
		
		initialize: function(){
		},
		
		render: function(){
			var template_options = {};
			this.template = _.template(view_template, template_options);
			var new_view = this.$el.html(this.template());
			
			return new_view;
		}
	});
	
	return PageView;
});