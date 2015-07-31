requirejs.config({
	"paths": {
		"app":".",
		"jquery":"https://code.jquery.com/jquery-1.11.3.min",
		"underscore":"https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore-min",
		"backbone":"https://cdnjs.cloudflare.com/ajax/libs/backbone.js/1.2.1/backbone-min"		
	}
});

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