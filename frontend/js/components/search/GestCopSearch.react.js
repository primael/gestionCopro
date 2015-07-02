var React = require('react');
var GestCopSearchDropDown = require('./GestCopSearchDropDown.react');

var GestCopSearch = React.createClass({

	search: function(){
		console.log("search element: " + $('#textSearch').val());
		console.log($('#zonalSearch').attr('data-zone'));
	},

	render:function(){

		var items = [{
			id:1,
			class:"glyphicon-menu-hamburger",
			zone:'ALL'
		}, {
			id:2,
			class:"glyphicon-user",
			zone:'USER'
		}, {
			id:3,
			class:"glyphicon-stats",
			zone:'BUILDING'
		}, {
			id:4,
			class:"glyphicon-folder-open",
			zone:'DOCUMENT'
		}];

		var gestCopSearchDropDown = <GestCopSearchDropDown list={items} selected={items[0]} />;

		return (
			<div className="input-group">
				{gestCopSearchDropDown}
				<input id="textSearch" type="text" className="form-control" placeholder="Rechercher dans l'application" />
				<div className="input-group-btn">
					<a role="button" className="btn btn-default" onClick={this.search}>
						<span className="glyphicon glyphicon-search" aria-hidden="true"></span>
					</a>
				</div>
			</div>
		);
	},
	
});

module.exports = GestCopSearch;