addEventListener('DOMContentLoaded', () => {
    const barra_nav_toggle = document.querySelector('.barra_nav_toggle')
    if(barra_nav_toggle){
        barra_nav_toggle.addEventListener('click', () => {
            const nav = document.querySelector('.nav')
            nav.classList.toggle('show')
        })
    }
})