// script.js
function appendToDisplay(value) {
    document.getElementById('display').value += value;
}

function clearDisplay() {
    document.getElementById('display').value = '';
}

function calculateResult() {
    const displayValue = document.getElementById('display').value;
    try {
        if(displayValue === 'unko') {
            alert('unko sitai')
        }
        const result = eval(displayValue);
        result = 'aaa'
        document.getElementById('display').value = result;
    } catch (error) {
        alert('Invalid expression!');
        clearDisplay();
    }
}
