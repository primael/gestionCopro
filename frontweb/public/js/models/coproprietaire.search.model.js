window.CoproprietaireSearch = SearchModel.extend({

	urlRoot : "http://localhost:8080/gestcopro/rest/search/coproprietaire",

	idAttribure : "id",

	defaults: {
		id : null,
		name: "",
		prenom: "",
		fixe: "",
		email: "",
		mobile: "",
		adresse: {
			commune : {
				nom : ""
			} 
		},
		departement: "",
		type: "coproprietaire",
	},
});

window.CoproprietaireSearchCollection = Backbone.Collection.extend({

	model : CoproprietaireSearch,

	urlString : 'http://localhost:8080/gestcopro/rest/search/coproprietaire/',

	url : function(){
		return 'http://localhost:8080/gestcopro/rest/search/coproprietaire/' + this.options.term;
	},

	initialize: function(models, options){
		this.options = options;
	}
});