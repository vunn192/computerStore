let button = document.getElementById("search-button");

button.onclick = function (){
    let dataSearch = document.getElementById("searchProduct").value;
    dataSearch = dataSearch.trim();

    if (dataSearch != ""){
        const searchUrl = "/search?q=" + encodeURIComponent(dataSearch);
        window.location.href = searchUrl;
    }
};

const url = new URL(window.location.href);
const searchParams = url.searchParams;
const query = searchParams.get('q');

if (query) {
    fetch("/products?q=" + encodeURIComponent(query))
        .then(response => response.json())
        .then(data => {
            console.log(data);
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
                    let cart = JSON.parse(sessionStorage.getItem('cart'));
                    cart.push(item);
                    sessionStorage.setItem('cart', JSON.stringify(cart));
                    let cartNotice = document.querySelector('.cart-notice');
                    cartNotice.innerHTML = cart.length;
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
            })
        })
        .catch(Error =>{
            console.log("Error: " + Error);
        });
}
