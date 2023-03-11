function logDateTime() {
    const now = new Date();
    const year = now.getFullYear();
    let month = now.getMonth() + 1;
    const day = now.getDate();
    const hour = now.getHours();
    let minute = now.getMinutes();
  
    const months = {
      1: "January",
      2: "February",
      3: "March",
      4: "April",
      5: "May",
      6: "June",
      7: "July",
      8: "August",
      9: "September",
      10: "October",
      11: "November",
      12: "December",
    };
    
    const date = `${day} ${months[month]} ${year}`;
    let time = `${hour}:${minute}`;
    if (minute < 10) {
      time = `${hour}:0${minute}`;
    }
  
    const weekNumber = moment(now);
    const weekOfMonth = weekNumber.week() - moment(weekNumber).startOf('month').week() + 1;
  
    document.getElementById("date").innerHTML = date;
    document.getElementById("time").innerHTML = time;
  }
  
  setInterval(logDateTime, 10000);
  
  function uploadFile() {
    // Get the file input field
    var fileInput = document.getElementById('fileInput');
    
    
    // Get the selected file
    var file = fileInput.files[0];
  
    // Create a new FormData object
    var formData = new FormData();
    
    // Add the file to the FormData object
    formData.append('file', file);
    formData.append('title', 'My file upload');
    console.log(formData.get('file'));
    // Send the form data to the server using an AJAX request
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/upload', true);
    
    xhr.send(formData);
  }
  
  function clearButton() {
    var searchInput = document.querySelector('#navigation input[type="text"]');
    searchInput.value = '';
  }
  
  function configure(button) {
    const checkboxes = button.parentNode.parentNode.querySelectorAll('input[type="checkbox"]');
    checkboxes.forEach((checkbox) => {
      checkbox.disabled = !checkbox.disabled;
    });
    if (button.value === "configure") {
      checkboxes.forEach((checkbox) => {
        checkbox.removeAttribute('disabled');
      });
      button.value = "save";
    } else {
      checkboxes.forEach((checkbox) => {
        checkbox.setAttribute('disabled', '');
      });
      button.value = "configure";
    }
  }
  
  var selectedElement
  function selectBox(element){
    if (selectedElement) {
      selectedElement.classList.remove('selected');
    }
    element.classList.add('selected');
    selectedElement = element;
  }
  
  document.addEventListener('click', function(event) {
    // Check if the clicked element is not the selected element
    if (selectedElement && event.target !== selectedElement) {
      var box1 = document.getElementById('box-1');
      var box2 = document.getElementById('box-2');
      if (event.target == box1 && event.target == box2) {
        selectedElement.classList.remove('selected');
        selectedElement = null;
      }
    }
  });