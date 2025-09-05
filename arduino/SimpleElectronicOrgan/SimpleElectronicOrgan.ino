#include <Keypad.h>

const byte ROWS = 4; 
const byte COLS = 4; 

char keys[ROWS][COLS] = {
  {'1', '2', '3', 'A'},
  {'4', '5', '6', 'B'},
  {'7', '8', '9', 'C'},
  {'*', '0', '#', 'D'}
};

byte rowPins[ROWS] = {2, 3, 4, 5}; 
byte colPins[COLS] = {6, 7, 8, 9}; 

Keypad keypad = Keypad(makeKeymap(keys), rowPins, colPins, ROWS, COLS);

const int buzzerPin = 10; // Buzzer connected to pin 10
const int duration = 500; // Note duration in ms

void setup() {
  pinMode(buzzerPin, OUTPUT);
}

void loop() {
  char key = keypad.getKey();
  if (key) {
    playNote(key);
  }
}

void playNote(char note) {
  int frequency = getFrequency(note);
  if (frequency > 0) {
    tone(buzzerPin, frequency, duration);
    delay(duration);
    noTone(buzzerPin);
  }
}

int getFrequency(char key) {
  switch (key) {
    case '0': return 523; // Do
    case '1': return 587; // Re
    case '2': return 659; // Mi
    default: return 0;    // No sound
  }
}
