// 첫 번째 슬라이드 세트
		const prevButton_1 = document.getElementById('prev_1');
		const nextButton_1 = document.getElementById('next_1');
		const slides_1 = document.querySelector('.slides');
		const slideItems_1 = slides_1.querySelectorAll('.slide');

		let currentIndex_1 = 0;

		// 두 번째 슬라이드 세트
		const prevButton_2 = document.getElementById('prev_2');
		const nextButton_2 = document.getElementById('next_2');
		const slides_2 = document.querySelector('.slides_2');
		const slideItems_2 = slides_2.querySelectorAll('.slide');

		let currentIndex_2 = 0;
		
		// 두 번째 슬라이드 세트
		const prevButton_3 = document.getElementById('prev_3');
		const nextButton_3 = document.getElementById('next_3');
		const slides_3 = document.querySelector('.slides_3');
		const slideItems_3 = slides_3.querySelectorAll('.slide');

		let currentIndex_3 = 0;

		function showSlide_1(index) {
			currentIndex_1 = index;
			const startIndex = currentIndex_1 * 4;
			const endIndex = startIndex + 4;

			// 첫 번째 세트의 모든 슬라이드 아이템 숨기기
			slideItems_1.forEach((item, i) => {
				if (i === currentIndex_1) {
					item.style.display = 'block';
				} else {
					item.style.display = 'none';
				}
			});
		}

		function showSlide_2(index) {
			currentIndex_2 = index;
			const startIndex = currentIndex_2 * 4;
			const endIndex = startIndex + 4;

			// 두 번째 세트의 모든 슬라이드 아이템 숨기기
			slideItems_2.forEach((item, i) => {
				if (i === currentIndex_2) {
					item.style.display = 'block';
				} else {
					item.style.display = 'none';
				}
			});
		}
		
		function showSlide_3(index) {
			currentIndex_3 = index;
			const startIndex = currentIndex_3 * 4;
			const endIndex = startIndex + 4;

			// 두 번째 세트의 모든 슬라이드 아이템 숨기기
			slideItems_3.forEach((item, i) => {
				if (i === currentIndex_3) {
					item.style.display = 'block';
				} else {
					item.style.display = 'none';
				}
			});
		}

		// 각 세트의 이전 및 다음 버튼에 대한 이벤트 리스너 추가
		prevButton_1.addEventListener('click', () => {
			currentIndex_1 -= 1;
			if (currentIndex_1 < 0) {
				currentIndex_1 = slideItems_1.length - 1;
			}
			showSlide_1(currentIndex_1);
		});

		nextButton_1.addEventListener('click', () => {
			currentIndex_1 = (currentIndex_1 + 1) % slideItems_1.length;
			showSlide_1(currentIndex_1);
		});

		prevButton_2.addEventListener('click', () => {
			currentIndex_2 -= 1;
			if (currentIndex_2 < 0) {
				currentIndex_2 = slideItems_2.length - 1;
			}
			showSlide_2(currentIndex_2);
		});

		nextButton_2.addEventListener('click', () => {
			currentIndex_2 = (currentIndex_2 + 1) % slideItems_2.length;
			showSlide_2(currentIndex_2);
		});
		
		prevButton_3.addEventListener('click', () => {
			currentIndex_3 -= 1;
			if (currentIndex_3 < 0) {
				currentIndex_3 = slideItems_3.length - 1;
			}
			showSlide_3(currentIndex_3);
		});

		nextButton_3.addEventListener('click', () => {
			currentIndex_3 = (currentIndex_3 + 1) % slideItems_3.length;
			showSlide_3(currentIndex_3);
		});

		// 두 세트를 첫 번째 슬라이드로 초기화
		showSlide_1(currentIndex_1);
		showSlide_2(currentIndex_2);
		showSlide_3(currentIndex_3);
		
		
