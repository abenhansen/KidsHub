function loginSyS() {
    var bruger = document.loginform.bruger.value;
    var kode = document.loginform.kode.value;
    var username = "admin";
    var password = "1234";
    var user2 = "pedo";
    var password2 = "kidshub";
    if ((bruger == username) && (kode == password)|| (bruger=user2) && (kode==pw2)) {
        return true;
    }
    else {
        alert ("Forkert login, prøv igen!")
        return false;
    }
}