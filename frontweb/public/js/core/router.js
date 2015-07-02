define(function(require) {
	var Backbone = require('Backbone');
	var viewManager = require('./viewManager');

	var Router = Backbone.Router.extend({
		routes: {
			'': 'home',
			'search': 'search'
		},

		home: function () {
			require('./../apps/home/app').run(viewManager);
		},
		search: function () {
			require('./../apps/search/app').run(viewManager);s
		}
	});

	return Router;
});