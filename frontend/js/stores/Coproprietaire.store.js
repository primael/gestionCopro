var Backbone = require("backbone");
var AppDispatcher = require("../dispatcher");

var Coproprietaire = Backbone.Model.extend({
	defaults: {
		id : "",
		name: "",
		prenom: "",
		fixe: "",
		email: ""
	},
	idAttribure : "id",
	initialize: function(){
		console.log('Coproprietaire has been initialized');
		this.on("invalid", function(model, error) {
			console.log("Houston, we've got a problem: " + error);
		});
	},
	urlRoot: 'http://localhost:8080/rest/coproprietaire'
});

var CoproprietairesCollection = Backbone.Collection.extend({
	model: Coproprietaire,
	url: 'http://localhost:8080/rest/coproprietaire',
});

var Coproprietaires