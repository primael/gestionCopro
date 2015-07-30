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
        
        return true;
    }
});