import React,{Component} from 'react';
import axios from 'axios';

import './Reviews.css';

class Reviews extends Component{

    state = {
        reviewsArray : null,
        currentProductId: null
    }

    componentDidUpdate(){
        if(this.props.product && this.props.product.id !== this.state.currentProductId){
            const url = 'http://localhost:8080/products/'+this.props.product.id+'/reviews';
            axios.get(url)
            .then(response => {
                this.setState({
                    reviewsArray: response.data,
                    currentProductId: this.props.product.id
                });
            })
        }
    }
    render(){
        
        if(this.state.reviewsArray){
            var reviewsDisplay = this.state.reviewsArray.map(aReviewObj =>{
                return (
                    <div key={aReviewObj.id} className="areview">
                    <h4> Author: {aReviewObj.author} </h4>
                    <p> {aReviewObj.text} </p>
                    <h4> Rating: {aReviewObj.rating} </h4>
                    </div>
                );
            });

            return (
                <div className="reviews">
                    {reviewsDisplay}

            </div>
            );

        }else{
            return (
                <div className="reviews"></div>
            );
        }
    }

}
export default Reviews;