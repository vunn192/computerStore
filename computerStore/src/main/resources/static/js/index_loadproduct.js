import {addItem} from "./cart.js";

fetch("/products")
    .then(response => response.json())
    .then(data => {
        let bestSellersElement = document.querySelector('.best-sellers');

        data.forEach((item) =>{
            let itemElement = document.createElement('section');
            itemElement.classList.add('item')
            bestSellersElement.appendChild(itemElement);

            let imgElement = document.createElement('section');
            imgElement.classList.add('item-img');
            imgElement.style.backgroundImage = `url(${item._img})`;
            itemElement.appendChild(imgElement);

            let nameElement = document.createElement('span');
            nameElement.classList.add('item-name');
            nameElement.innerText = item._name;
            itemElement.appendChild(nameElement);

            let btnWrap = document.createElement('section');
            btnWrap.classList.add('item-btn-wrap');

            let priceElement = document.createElement('span');
            priceElement.classList.add('item-price');
            priceElement.innerText = Number(item._price).toLocaleString() + 'đ';
            btnWrap.appendChild(priceElement);

            let btnAdd = document.createElement('button');
            btnAdd.classList.add('btn', 'btn-add-cart');

            btnAdd.onclick = function(e){
                e.stopPropagation();
                addItem(item);
            }

            let iconAdd = document.createElement('i');
            iconAdd.classList.add('fas', 'fa-cart-plus');
            btnAdd.appendChild(iconAdd);
            var t = document.createTextNode('Thêm vào giỏ');
            btnAdd.appendChild(t);
            btnWrap.appendChild(btnAdd);

            itemElement.appendChild(btnWrap);

            //item onclick
            itemElement.onclick = function() {
                window.location.href = "/product";
                localStorage.setItem("currentItemId", item._id);
            }
        });

        let productElement = document.querySelector('.content-product');

        data.forEach((item) => {
            let itemElement = document.createElement('section');
            itemElement.setAttribute('item_id', item._id);
            itemElement.setAttribute('array', 'arrFeatureProduct');
            itemElement.classList.add('item');
            productElement.appendChild(itemElement);

            let imgElement = document.createElement('section');
            imgElement.classList.add('item-img');
            imgElement.style.backgroundImage = `url(${item._img})`;
            itemElement.appendChild(imgElement);

            let nameElement = document.createElement('span');
            nameElement.classList.add('item-name');
            nameElement.innerText = item._name;
            itemElement.appendChild(nameElement);

            let btnWrap = document.createElement('section');
            btnWrap.classList.add('item-btn-wrap');

            let priceElement = document.createElement('span');
            priceElement.classList.add('item-price');
            priceElement.innerText = Number(item._price).toLocaleString() + 'đ';
            btnWrap.appendChild(priceElement);

            let btnAdd = document.createElement('button');
            btnAdd.classList.add('btn', 'btn-add-cart');
            btnAdd.onclick = function(e){
                e.stopPropagation();
                addItem(item);
            }
            let iconAdd = document.createElement('i');
            iconAdd.classList.add('fas', 'fa-cart-plus');
            btnAdd.appendChild(iconAdd);
            var t = document.createTextNode('Thêm vào giỏ');
            btnAdd.appendChild(t);
            btnWrap.appendChild(btnAdd);

            itemElement.appendChild(btnWrap);

            //item onclick
            itemElement.onclick = function() {
                window.location.href = "/product";
                localStorage.setItem("currentItemId", item._id);
            }
        });
    })
    .catch(error => {
        console.log("Error:", error);
    });
