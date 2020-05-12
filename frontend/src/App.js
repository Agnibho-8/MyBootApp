import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import './ProductGist/ProductGist';
import ProductGist from './ProductGist/ProductGist';
import ProductDetail from './ProductDetail/ProductDetail';
import axios from 'axios';
import Reviews from './Reviews/Reviews';

class App extends Component {

  state = {
    productList: [
      {id: 1, name: "Flame Thrower", price: 4999, qoh: 25000},
      {id: 2, name: "Beatle Dog", price: 25000, qoh: 4}
    ],
    selectedProduct: null
  }

  productSelectionHandler = (aProduct) => {
    this.setState({selectedProduct: aProduct});
  }

  componentDidMount(){
    axios.get('http://localhost:8080/products')
    .then(response =>{
      this.setState({productList:response.data});
    });
  }


  render() {
    const productGistTags = this.state.productList.map(aProductObject => {
      return (<ProductGist 
        key = {aProductObject.id}
        productName={aProductObject.name} 
        productPrice={aProductObject.price} 
          clickHandler={() => { this.productSelectionHandler(aProductObject)} }/>);
    });

    // console.log(productGistTags);
    // console.log(ProductDetail);

    return (
      <div className="App">
        <div className="sidebar">
            <div id="menu">
                <p>menu goes here</p>
            </div>
            <div className="productlist">
                {productGistTags}
            </div>
        </div>
        <div className="detailedproductinfo">
        <ProductDetail productToBeRendered={this.state.selectedProduct} />
        <Reviews product={this.state.selectedProduct} />
        </div>
      </div>
    );
  }
}

export default App;
