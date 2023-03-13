function validatePhoneNumber() {
  const phoneNumber = document.getElementById("telephone").value;
  const phoneNumberPattern = /^\d{3}-\d{3}-\d{4}$/;
  if (!phoneNumberPattern.test(phoneNumber)) {
    alert("Please enter a valid phone number in the format ###-###-####.");
    return false;
  }
  return true;
}
