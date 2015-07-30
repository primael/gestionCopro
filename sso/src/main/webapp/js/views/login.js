window.LoginView = Backbone.View.extend({

    initialize: function () {
        this.render();
    },

    render: function () {
        $(this.el).html(this.template());
        return this;
    },

    events: {
        "click .connexion"   : "connexion"
    },

    connexion: function () {
        //On lance la recherche non?
        console.log("tentative de connexion");
        event.preventDefault();
        var url='api/security/connect/';
        
        url = url + $('#loginText').val() + '/' + $('#passwordText').val();
        
        $.ajax({
        	url:url,
        	type:'GET',
        	success:function(data){
        		console.log(["Login request details: ", data]);
        		
        		if(data.error){
        			console.log(data.error.text);
        		} else {
        			app.navigate("home", true);
        		}
        	}
        });
    }
});