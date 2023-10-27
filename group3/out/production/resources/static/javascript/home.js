const prevButton = document.getElementById('prev1');
const nextButton = document.getElementById('next1');
const slides = document.querySelector('.slides');
const slideItems = slides.querySelectorAll('.slide');

let currentIndex1 = 0;

function showSlide(index) {
	currentIndex1 = index;
	const startIndex = currentIndex1 * 4;
	const endIndex = startIndex + 4;

	// 모든 슬라이드 아이템을 숨김
	slideItems.forEach((item, i) => {
		if (i === currentIndex1) {
			item.style.display = 'block';
		} else {
			item.style.display = 'none';
		}
	});
}

// 이전 버튼 클릭 시
prevButton.addEventListener('click', () => {
	currentIndex1 -= 1;
	if (currentIndex1 < 0) {
		currentIndex1 = slideItems.length - 1;
	}
	showSlide(currentIndex1);
});

// 다음 버튼 클릭 시
nextButton.addEventListener('click', () => {
	currentIndex1 = (currentIndex1 + 1) % slideItems.length;
	showSlide(currentIndex1);
});

// 초기 슬라이드 표시
showSlide(currentIndex1);