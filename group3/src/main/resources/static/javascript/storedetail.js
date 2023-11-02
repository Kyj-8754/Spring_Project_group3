document.addEventListener("DOMContentLoaded", function() {

	// 김용진 코멘트 = 변수값입니다 바꾸시면 안됨니다.
	var address = document.getElementById('storeaddr').textContent;
	// address를 사용하여 원하는 작업을 수행
	var storename = document.getElementById('store_name').textContent;
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center: new kakao.maps.LatLng(37.497815, 127.026541), // 지도의 중심좌표 디폴트는 강남역 12번출구로 설정
			level: 3 // 지도의 확대 레벨
		};
	// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption);

	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다
	// 여기에 위에 설정한 변수 address가 들어가서 지도에 표시가 됨니다.
	geocoder.addressSearch(address, function(result, status) {

		// 정상적으로 검색이 완료됐으면 
		if (status === kakao.maps.services.Status.OK) {

			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

			// 결과값으로 받은 위치를 마커로 표시합니다
			var marker = new kakao.maps.Marker({
				map: map,
				position: coords
			});

			// 인포윈도우로 장소에 대한 설명을 표시합니다, 김용진 코멘트 = 강남 버거킹 대신, 변수를 집어넣으면 해당 지도 해당부분 에 텍스트가 나옴니다.
			var infowindow = new kakao.maps.InfoWindow({
				content: '<div style="width:150px;text-align:center;padding:6px 0;">' + storename + '</div>'
			});
			infowindow.open(map, marker);

			// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			map.setCenter(coords);
		}
	});
});
//예약 달력 꺼내주는 스크립트
// "예약하기" 버튼 클릭 이벤트 처리
function toggleReservations() {
	var reservationsDiv = document.getElementById("reservations");

	if (reservationsDiv.style.display === "none") {
		reservationsDiv.style.display = "block"; // Show the reservations div
	} else {
		reservationsDiv.style.display = "none"; // Hide the reservations div
	}
}
//최상단 올라가는 기능, url복사

function clip() {

	var url = '';    // <a>태그에서 호출한 함수인 clip 생성
	var textarea = document.createElement("textarea");
	//url 변수 생성 후, textarea라는 변수에 textarea의 요소를 생성

	document.body.appendChild(textarea); //</body> 바로 위에 textarea를 추가(임시 공간이라 위치는 상관 없음)
	url = window.document.location.href;  //url에는 현재 주소값을 넣어줌
	textarea.value = url;  // textarea 값에 url를 넣어줌
	textarea.select();  //textarea를 설정
	document.execCommand("copy");   // 복사
	document.body.removeChild(textarea); //extarea 요소를 없애줌

	alert("URL이 복사되었습니다.")  // 알림창
}

window.onload = function() { buildCalendar(); }    // 웹 페이지가 로드되면 buildCalendar 실행

let nowMonth = new Date();  // 현재 달을 페이지를 로드한 날의 달로 초기화
let today = new Date();     // 페이지를 로드한 날짜를 저장
today.setHours(0, 0, 0, 0);    // 비교 편의를 위해 today의 시간을 초기화

// 달력 생성 : 해당 달에 맞춰 테이블을 만들고, 날짜를 채워 넣는다.
function buildCalendar() {

	let firstDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth(), 1);     // 이번달 1일
	let lastDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, 0);  // 이번달 마지막날

	let tbody_Calendar = document.querySelector(".Calendar > tbody");

	document.getElementById("calYear").innerText = nowMonth.getFullYear();
	document.getElementById("calMonth").innerText = leftPad(nowMonth.getMonth() + 1);

	const yearValue = document.getElementById("calYear").innerText;
	const monthValue = document.getElementById("calMonth").innerText;

	console.log("연도:", yearValue);
	console.log("월:", monthValue);

	document.getElementById("selectedYear").value = yearValue;
	document.getElementById("selectedMonth").value = monthValue;


	while (tbody_Calendar.rows.length > 0) {                        // 이전 출력결과가 남아있는 경우 초기화
		tbody_Calendar.deleteRow(tbody_Calendar.rows.length - 1);
	}

	let nowRow = tbody_Calendar.insertRow();        // 첫번째 행 추가           

	for (let j = 0; j < firstDate.getDay(); j++) {  // 이번달 1일의 요일만큼
		let nowColumn = nowRow.insertCell();        // 열 추가
	}

	for (let nowDay = firstDate; nowDay <= lastDate; nowDay.setDate(nowDay.getDate() + 1)) {   // day는 날짜를 저장하는 변수, 이번달 마지막날까지 증가시키며 반복  

		let nowColumn = nowRow.insertCell();        // 새 열을 추가하고


		let newDIV = document.createElement("p");
		newDIV.innerHTML = leftPad(nowDay.getDate());        // 추가한 열에 날짜 입력
		nowColumn.appendChild(newDIV);

		if (nowDay.getDay() == 6) {                 // 토요일인 경우
			nowRow = tbody_Calendar.insertRow();    // 새로운 행 추가
		}

		if (nowDay < today) {                       // 지난날인 경우
			newDIV.className = "pastDay";
		}
		else if (nowDay.getFullYear() == today.getFullYear() && nowDay.getMonth() == today.getMonth() && nowDay.getDate() == today.getDate()) { // 오늘인 경우           
			newDIV.className = "today";
			newDIV.onclick = function() { choiceDate(this); }
		}
		else {                                      // 미래인 경우
			newDIV.className = "futureDay";
			newDIV.onclick = function() { choiceDate(this); }
		}
	}
}

// 이전달 버튼 클릭
function prevCalendar() {
	nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() - 1, nowMonth.getDate());   // 현재 달을 1 감소
	buildCalendar();    // 달력 다시 생성
}
// 다음달 버튼 클릭
function nextCalendar() {
	nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, nowMonth.getDate());   // 현재 달을 1 증가
	buildCalendar();    // 달력 다시 생성
}

// input값이 한자리 숫자인 경우 앞에 '0' 붙혀주는 함수
function leftPad(value) {
	if (value < 10) {
		value = "0" + value;
		return value;
	}
	return value;
}
function choiceDate(newDIV) {
	if (document.getElementsByClassName("choiceDay")[0]) {
		document.getElementsByClassName("choiceDay")[0].classList.remove("choiceDay");
	}
	newDIV.classList.add("choiceDay");


	const selectedDay = newDIV.textContent;  // 선택한 날짜 텍스트

	document.getElementById("selectedDay").value = selectedDay;
}

function setMemberId() {
	const memberidInput = document.getElementById("memberid");
	const selectedMemberId = memberidInput.value;

	// 선택한 회원 ID를 memberid 필드에 설정
	document.getElementById("selectedDay").value = selectedMemberId;
}
window.addEventListener("scroll", function() {
	var scrollToTopButton = document.getElementById("scrollToTopButton");
	if (window.scrollY > 200) { // 200픽셀 이상 스크롤하면 버튼을 표시합니다
		scrollToTopButton.style.display = "block";
	} else { // 200픽셀 미만으로 스크롤하면 버튼을 숨깁니다
		scrollToTopButton.style.display = "none";
	}
});

document.getElementById("scrollToTopButton").addEventListener("click", function() {
	window.scrollTo({ top: 0, behavior: 'smooth' }); // 버튼을 클릭하면 페이지 상단으로 부드럽게 스크롤합니다
});

const year = document.getElementById("calYear").innerText
const month = document.getElementById("calMonth").innerText

document.getElementById("selectedYear").value = year
document.getElementById("selectedMonth").value = month
