document.addEventListener("DOMContentLoaded", function() {
	const slideshows = document.querySelectorAll('.section_card');

	slideshows.forEach((slideshow) => {
		const track = slideshow.querySelector('.slick_track');
		const prevButton = slideshow.querySelector('.slick_prev');
		const nextButton = slideshow.querySelector('.slick_next');

		let slideWidth = track.querySelector('.slick_slide').clientWidth + 9; // 10px는 간격입니다.
		let currentPosition = 0;
		const slidesInView = 4; // 한 번에 보여지는 슬라이드 개수

		nextButton.addEventListener('click', function() {
			const remainingSlides = track.children.length - (Math.abs(currentPosition) / slideWidth + slidesInView);
			const distance = remainingSlides >= slidesInView ? slideWidth * slidesInView : slideWidth * remainingSlides;

			currentPosition -= distance;

			if (currentPosition < -slideWidth * (track.children.length - slidesInView)) {
				currentPosition = -slideWidth * (track.children.length - slidesInView);
			}

			track.style.transform = `translateX(${currentPosition}px)`;
		});

		prevButton.addEventListener('click', function() {
			const remainingSlides = Math.abs(currentPosition) / slideWidth;
			const distance = remainingSlides >= slidesInView ? slideWidth * slidesInView : slideWidth * remainingSlides;

			currentPosition += distance;

			if (currentPosition > 0) {
				currentPosition = 0;
			}

			track.style.transform = `translateX(${currentPosition}px)`;
		});
	});
});