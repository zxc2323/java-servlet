document.getElementById('ModifierButton').addEventListener('click', function() {
  var ModifierDiv = document.getElementById('ModifierLC');
  if (ModifierDiv.style.display === 'none') {
    ModifierDiv.style.display = 'block'; // 显示 div
  } else {
    ModifierDiv.style.display = 'none'; // 隐藏 div
  }
});

function sendRequest() {
    var inputData = document.getElementById('ModifierPI').value;
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'LCindex', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var parser = new DOMParser();
            var xmlDoc = parser.parseFromString(xhr.responseText, "text/xml");
            var status = xmlDoc.getElementsByTagName("status")[0].childNodes[0].nodeValue;
			document.getElementById('cont').textContent = status;
        } else if (xhr.readyState === 4) {
            document.getElementById('resultat').textContent = 'An error occurred during the request.';
        }
    };
    xhr.send('postit=' + encodeURIComponent(inputData));
}