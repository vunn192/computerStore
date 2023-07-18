import {addItem} from "./cart.js";

let currentUrl =  window.location.href;
let ifPresent = currentUrl.includes("/laptop");
let lastSegment = currentUrl.split("/").pop();

if (ifPresent) {
    fetch("/search-product/" + encodeURIComponent(lastSegment))
        .then(response => response.json())
        .then(data => {
            let brandName = document.querySelector('.brand-title');
            brandName.innerHTML = lastSegment.toUpperCase();
            let productElement = document.querySelector('.content-dsSanpham');

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
        .catch(Error =>{
            console.log("Error: " + Error);
        })
}

fetch("/brands")
    .then(response => response.json())
    .then(data => {
        let menuBrand = document.querySelector(".menu-drop");

        data.forEach((item) => {
            let brandItem = document.createElement("a");
            brandItem.setAttribute("href", "/laptop/" + encodeURIComponent(item._name));
            brandItem.innerHTML = item._name.toUpperCase();
            menuBrand.appendChild(brandItem);
        })
    })
    .catch(Error =>{
       console.log("Error: " + Error);
    });

