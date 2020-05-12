import React,{Component} from 'react';
import './ProductDetail.css';

class ProductDetail extends Component{


    render(){
        if(this.props.productToBeRendered){
            return (
                <div className="productinfo">
                <p className="productname">Product {this.props.productToBeRendered.id} {this.props.productToBeRendered.name}</p>
                <img src={this.props.productToBeRendered.image} />
                <p className="productname">Rs. {this.props.productToBeRendered.price}</p>
                <p className="productqoh">Available Qty : {this.props.productToBeRendered.qoh}</p>
            </div>
            );
        }else{
            return (<div className="productinfo"> </div>);
        }
    }

}

export default ProductDetail;