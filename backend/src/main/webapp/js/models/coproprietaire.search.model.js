window.CoproprietaireSearch = SearchModel.extend({

	urlRoot : "/gestcopro/rest/search/coproprietaire",

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

	urlString : '/gestcopro/rest/search/coproprietaire/',

	url : function(){
		return '/gestcopro/rest/search/coproprietaire/' + this.options.term;
	},

	initialize: function(models, options){
		this.options = options;
	}
});