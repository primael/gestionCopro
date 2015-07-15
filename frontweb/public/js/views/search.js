window.SearchView = Backbone.View.extend({

    initialize: function () {
        this.render();
    },

    render: function () {
        $(this.el).html(this.template());
        return this;
    },

    events: {
        "click .search"   : "beforeSearch",
        "click .allSearch" : "changeItemAll",
        "click .userSearch" : "changeItemUser",
        "click .buildingSearch" : "changeItemBuilding",
    },

    selectMenuItem: function (menuItem) {
        $('.nav li').removeClass('active');
        if (menuItem) {
            $('.' + menuItem).addClass('active');
        }
    },

    beforeSearch: function () {
        //On lance la recherche non?
        this.search();
        return false;
    },

    search: function () {        

        console.log('élément recherché : ' + $('#textSearch').val() + ' zone de recherche : ' + $('#zoneSearch').attr("data-zone"));
        
    },

    changeItemAll: function(){
        console.log('élément recherché : ' + $('#textSearch').val() + ' zone de recherche : ' + $('#zoneSearch').attr("data-zone"));
        $('#zoneSearch').removeClass().addClass('glyphicon glyphicon-menu-hamburger').attr('data-zone','ALL');
    },

    changeItemUser: function(){
        console.log('élément recherché : ' + $('#textSearch').val() + ' zone de recherche : ' + $('#zoneSearch').attr("data-zone"));
        $('#zoneSearch').removeClass().addClass('glyphicon glyphicon-user').attr('data-zone','USER');
    },

    changeItemBuilding: function(){
        console.log('élément recherché : ' + $('#textSearch').val() + ' zone de recherche : ' + $('#zoneSearch').attr("data-zone"));
        $('#zoneSearch').removeClass().addClass('glyphicon glyphicon-stats').attr('data-zone','BUILDING');
    },
});