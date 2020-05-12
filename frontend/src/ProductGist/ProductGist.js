import React, {Component} from 'react';

import './ProductGist.css';

class ProductGist extends Component {
    render(){
        return (
            <p className="productgist" onClick={this.props.clickHandler}>{this.props.productName} Rs. {this.props.productPrice} </p>
        );
    }
}

export default ProductGist;