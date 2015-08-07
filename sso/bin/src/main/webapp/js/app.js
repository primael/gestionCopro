define([
        'jquery',
        'underscore',
        'backbone',
        'router',
], function($, _, Backbone, Router){
	
	Backbone.View.prototype._views = {};
	
	Backbone.View.prototype._models = [];
	
	Backbone.View.prototype.on_close = function(){
		
		//unbind all of the model events.
		_.each(this._models, function(model){
			model.unbind();
		});
		
		//unbind the view events
		this.unbind();
		
		//remove the view template from the screen
		$(this.template).remove();
	}
	
	var initialize = function(){
		//Pass in our Router module and call it's initialize function
		Router.init();
	};
	
	return {
		initialize: initialize
	};
});