let carouselIndex = 1;

function showCarousel() {
  const slides = document.getElementsByClassName("pzbf-carousel__slide");
  const dots = document.getElementsByClassName("pzbf-carousel__dot");
  for (let i = 0; i < slides.length; i++) {
    slides[i].className = slides[i].className.replace(" pzbf-carousel__slide--active", "");
  }
  for (let i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" pzbf-carousel__dot--active", "");
  }
  slides[carouselIndex-1].className += " pzbf-carousel__slide--active";
  dots[carouselIndex-1].className += " pzbf-carousel__dot--active";
}

showCarousel(carouselIndex);

function currentSlide(dotNumber) {
  showCarousel(carouselIndex = dotNumber);
}
