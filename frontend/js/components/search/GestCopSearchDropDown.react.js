var React = require('react');

var GestCopSearchDropDown = React.createClass({

	getInitialState : function(){
		return {
			listVisible: false
		};
	},

	select : function(item){
		this.props.selected = item;
	},

	show : function(){
		this.setState({listVisible: true});
		document.addEventListener("click", this.hide);
	},

	hide : function(){
		this.setState({listVisible:false});
		document.removeEventListener("click", this.hide);
	},

	render : function(){
		return (
			<div className="input-group-btn">
				<button type="button" className="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="false" aria-expanded="true" onClick={this.show}>
					<span  id="zonalSearch" className={"glyphicon " + this.props.selected.class} aria-hidden="true" data-zone={this.props.selected.zone}></span>
				</button>
				<ul className="dropdown-menu">
					{this.renderListItems()}
				</ul>
			</div>
		)
	},

	renderListItems : function(){
		var itemList = [];
		for (var i = 0; i <this.props.list.length; i++){
			var item = this.props.list[i];
			itemList.push(
				<li key={item.id} >
					<a href="#"  onClick={this.select.bind(null, item)}><span className={"glyphicon " + item.class} aria-hidden="true" data-zone={item.zone}></span></a>
				</li>);
		}

		return itemList;

	}
});

module.exports = GestCopSearchDropDown;