let btnf1 = document.getElementById('switch-btn1');
let btnf2 = document.getElementById('switch-btn2');
let login_form = document.getElementById('login-form');
let reg_form = document.getElementById('reg-form');

btnf1.onclick = function() {
   login_form.style.display = 'none';
   reg_form.style.display = 'block';
};

//nút chuyển
btnf2.onclick = function() {
   if(username.value.trim() || email.value.trim()
       || password.value.trim() || repassword.value.trim()){
      let cf = confirm('Bạn có muốn chuyển trang');
      if(cf){
         //chuyển form và xóa các value
         reg_form.style.display = 'none';
         login_form.style.display = 'block';
         username.value = '';
         email.value = '';
         password.value = '';
         repassword.value = '';
      }
   } else if(!(username.value.trim() && email.value.trim()
       && password.value.trim() && repassword.value.trim())){
      reg_form.style.display = 'none';
      login_form.style.display = 'block';
   }
};

// Validation form
let form = document.querySelector('.auth__form');

let username = document.getElementById('username');
let email = document.getElementById('email');
let password = document.getElementById('password');
let repassword = document.getElementById('re-password');

let inputs = form.querySelectorAll('.input');

// Check bỏ trống
for(let i = 0 ; i < inputs.length ; i++){
   inputs[i].onblur = inputs[i].oninput = function() {
      if(inputs[i].value.trim()) {
         setSuccessFor(inputs[i]);
      } else {
         setErrorFor(inputs[i], 'Trường này không được bỏ trống');
      }
   }
}

//check username <3 ký tự
username.onblur = username.oninput = function() {
   if(username.value.trim().length < 3) {
      setErrorFor(username, 'Tên đăng nhập phải lớn hơn 3 ký tự');
   } else {
      setSuccessFor(username);
   }
}

//regex email:
//https://stackoverflow.com/questions/46155/how-to-validate-an-email-address-in-javascript
function isEmail(email) {
   const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
   return re.test(String(email).toLowerCase());
}
// Check email
email.onblur = email.oninput = function() {
   if(isEmail(email.value.trim())){
      setSuccessFor(email);
   } else {
      setErrorFor(email,'Trường này phải là email');
   }
}

// Check password <6 ký tự
password.onblur = password.oninput = function() {
   if(password.value.trim().length < 6) {
      setErrorFor(password, 'Mật khẩu phải lớn hơn 6 ký tự');
   } else {
      setSuccessFor(password);
   }
}

// Check trùng password
repassword.onblur = repassword.oninput = function() {
   if(repassword.value.trim() === password.value.trim()){
      setSuccessFor(repassword);
   } else {
      setErrorFor(repassword, 'Mật khẩu chưa trùng khớp');
   }
}

function setErrorFor(input, message) {
   const formControl = input.parentElement;
   const small = formControl.querySelector('small');
   small.innerText = message;
   formControl.className = 'form-control invalid';
   input.focus();
}
function setSuccessFor(input) {
   const formControl = input.parentElement;
   const small = formControl.querySelector('small');
   small.innerText = '';
   formControl.className = 'form-control valid';
}

let btnReg = document.getElementById('btnReg');

btnReg.onclick = function() {
   if(!(username.value.trim() || email.value.trim()
       || password.value.trim() || repassword.value.trim())){
      alert('Hãy điền đầy đủ các trường');
      if(!username.value.trim()) {
         setErrorFor(username,'Trường này không được bỏ trống');
      }
      if(!email.value.trim()) {
         setErrorFor(email,'Trường này không được bỏ trống');
      }
      if(!password.value.trim()) {
         setErrorFor(password,'Trường này không được bỏ trống');
      }
      if(!repassword.value.trim()) {
         setErrorFor(repassword,'Trường này không được bỏ trống');
      }
   } else {
      fetch("/user", {
         method: "POST",
         body: JSON.stringify({
            username: document.getElementById("username").value,
            email:  document.getElementById("email").value,
            password:  document.getElementById("password").value
         }),
         headers: {
            "Content-Type": "application/json"
         },
      });

      alert('Bạn đã đăng ký thành công. Hãy đăng nhập!');
      //hiện luôn form đăng nhập
      reg_form.style.display = 'none';
      login_form.style.display = 'block';
   }
}




