let content = document.querySelector(".content");
let connexion_form = document.querySelector(".connexion");
let inscription_form = document.querySelector(".inscription");

let inscription_button = document.getElementById("inscription");
let connexion_button = document.getElementById("connexion");

connexion_button.addEventListener('click', () => {
    connexion_form.style.display = 'flex';
    inscription_form.style.display = 'none';
    content.style.display = 'none';
});

inscription_button.addEventListener('click', () => {
    connexion_form.style.display = 'none';
    inscription_form.style.display = 'flex';
    content.style.display = 'none';
});