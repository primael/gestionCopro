window.Coproprietaire = Backbone.Model.extend({

	urlRoot : "/gestcopro/rest/coproprietaire",

	idAttribure : "id",

	defaults: {
		id : null,
		name: "",
		prenom: "",
		fixe: "",
		email: ""
	},

	initialize: function (){
		this.validators = {};

		this.validators.name = function(value) {
			return value.length > 0 ? {isValid: true} : {isValid : false, message: "Vous devez renseigner le nom."};
		};
	},

	validateItem: function(key){
		return (this.validators[key]) ? this.validators[key](this.get(key)) : {isValid: true};
	},

	validateAll: function(){
		var messages = {};

		for(var key in this.validators) {
			if(this.validators.hasOwnProperty(key)) {
				var check = this.validators[key](this.get(key));
				if(check.isValid === false){
					message[key] = check.message;
				}
			}
		}

		return _.size(messages) > 0 ? {isValid: false, message: messages} : {isValid: true};
	}
});

window.CoproprietaireCollection = Backbone.Collection.extend({
	model : Coproprietaire,
	url : "http://localhost:8080/gestcopro/rest/coproprietaire"
})