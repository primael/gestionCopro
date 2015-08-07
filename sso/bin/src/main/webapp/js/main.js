requirejs.config({
	paths: {
		jquery:"https://code.jquery.com/jquery-1.11.3.min",
		jqueryui:"https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min",
		validation:"https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.min",
		validation_addition:"https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/additional-methods.min",
		underscore:"https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore-min",
		backbone:"https://cdnjs.cloudflare.com/ajax/libs/backbone.js/1.2.1/backbone-min",
		bootstrap:"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min",
		backbone_router:"libs/backbone.routefilter",
		text:"https://cdnjs.cloudflare.com/ajax/libs/require-text/2.0.12/text.min",
		templates:"../tpl"
	},
	shim: {
		'jqueryui': ['jquery'],
		'bootstrap': ['jquery'],
		'validation': ['jquery'],
		'validation_addition': ['jquery', 'jquery.validate.min'],
		'backbone_router': ['jquery', 'underscore', 'backbone']
	}
});

require([
         
         'jquery', 
         'underscore',
         'app',
         'bootstrap'
], function($, _, App){
	
	App.initialize();
});

