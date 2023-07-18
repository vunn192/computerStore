function initializeCart() {
    let cart = JSON.parse(localStorage.getItem('cart'));
    if (!cart) {
        localStorage.setItem('cart', JSON.stringify([]))
    }
    else{
        let cartNotice = document.querySelector('.cart-notice');
        cartNotice.innerHTML = cart.length;
    }
}
function addItem(item){
    let cart = JSON.parse(localStorage.getItem('cart'));
    cart.push(item);
    saveCart(cart);
    let cartNotice = document.querySelector('.cart-notice');
    cartNotice.innerHTML = cart.length;
}

function deleteItem(Item){
    let cart = JSON.parse(localStorage.getItem('cart'));
    for (var i = cart.length - 1; i >= 0; i--) {
        if (JSON.stringify(cart[i]) == JSON.stringify(Item)) {
            cart.splice(i, 1);
            break;
        }
    }
    saveCart(cart);
    let cartNotice = document.querySelector('.cart-notice');
    cartNotice.innerHTML = cart.length;

    let totalPriceElement = document.getElementById('totalprice');
    let totalElement = document.getElementById('total');

    let totalPrice = totalPriceElement.innerHTML.replace('đ','').replaceAll('.','');
    let total = totalElement.innerHTML.replace('đ', '').replaceAll('.','');

    totalPriceElement.innerHTML = (Number(totalPrice) - Number(Item._price)).toLocaleString() + 'đ';
    totalElement.innerHTML = (Number(total) - Number(Item._price)).toLocaleString() + 'đ';
}
function saveCart(cart){
    localStorage.setItem('cart', JSON.stringify(cart));
}

initializeCart();

export { addItem, deleteItem };

