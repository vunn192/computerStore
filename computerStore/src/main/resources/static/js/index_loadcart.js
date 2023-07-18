import { deleteItem } from "./cart.js";

let cart = JSON.parse(localStorage.getItem('cart'));
let productElement = document.querySelector('.content-product');

let total = 0;
cart.forEach((item) =>{
    let itemElement = document.createElement('div');
    // itemElement.setAttribute('item_id', item.id);
    itemElement.classList.add('row')
    productElement.appendChild(itemElement);

    let imgElement = document.createElement('img');
    imgElement.classList.add('img');
    imgElement.classList.add('col-xl-3');
    imgElement.classList.add('col-md-3');
    imgElement.classList.add('col-lg-3');
    // imgElement.style.backgroundImage = `url(${item.img})`;
    imgElement.src = item._img;
    itemElement.appendChild(imgElement);

    let nameElement = document.createElement('div');
    nameElement.setAttribute('item_id', item._id);
    nameElement.classList.add('col-xl-7');
    nameElement.classList.add('col-md-7');
    nameElement.classList.add('col-lg-7');
    nameElement.innerText = item._name;
    itemElement.appendChild(nameElement);

    let priceElement = document.createElement('div');
    imgElement.classList.add('price');
    priceElement.classList.add('col-xl-2');
    priceElement.classList.add('col-md-2');
    priceElement.classList.add('col-lg-2');
    priceElement.innerText = Number(item._price).toLocaleString() + 'đ';
    itemElement.appendChild(priceElement);


    let btnWrap = document.createElement('section');
    btnWrap.classList.add('item-btn-wrap');


    let hrElement = document.createElement('hr');
    imgElement.classList.add('hrclass');
    itemElement.appendChild(hrElement);

    let btndelete = document.createElement('button');
    btndelete.classList.add('btn', 'btn-add-cart');
    btndelete.onclick = function(){
        deleteItem(item);
        itemElement.remove();
    }

    let iconAdd = document.createElement('i');
    iconAdd.classList.add('fas', 'fa-trash');
    btndelete.appendChild(iconAdd);
    var t = document.createTextNode('Xóa');
    btndelete.appendChild(t);
    btnWrap.appendChild(btndelete);

    nameElement.appendChild(btnWrap);

    total += Number(item._price);
});

document.getElementById('totalprice').innerHTML = Number(total).toLocaleString() + 'đ';
document.getElementById('total').innerHTML = Number(total).toLocaleString() + 'đ';


