#include <Wire.h>
#include <LiquidCrystal_I2C.h>

// LCD setup: address 0x27, 16 columns, 2 rows
LiquidCrystal_I2C lcd(0x27, 16, 2);

// Ultrasonic sensor pins
const int trigPin = 9;
const int echoPin = 10;

// Output pins
const int buzzerPin = 11;
const int ledPin = 12;

// Variables for duration and distance
long duration;
int distanceCm, distanceInch;

void setup() {
    // Initialize LCD
    lcd.begin(16, 2);
    lcd.backlight();

    // Set pin modes
    pinMode(trigPin, OUTPUT);
    pinMode(echoPin, INPUT);
    pinMode(buzzerPin, OUTPUT);
    pinMode(ledPin, OUTPUT);
}

void loop() {
    // Send ultrasonic pulse
    digitalWrite(trigPin, LOW);
    delayMicroseconds(2);
    digitalWrite(trigPin, HIGH);
    delayMicroseconds(10);
    digitalWrite(trigPin, LOW);

    // Measure pulse duration from echo
    duration = pulseIn(echoPin, HIGH);

    // Calculate distances
    distanceCm = duration * 0.034 / 2;     // cm
    distanceInch = duration * 0.0133 / 2;  // inches

    // Display distances on LCD
    lcd.setCursor(0, 0);
    lcd.print("Distance: " + String(distanceCm) + " cm ");
    lcd.setCursor(0, 1);
    lcd.print("Distance: " + String(distanceInch) + " in ");

    // Alert if object is closer or farther than threshold
    if (distanceInch > 5) { 
        digitalWrite(buzzerPin, HIGH); // Turn on buzzer
        digitalWrite(ledPin, HIGH);    // Turn on LED
    } else {
        digitalWrite(buzzerPin, LOW);  // Turn off buzzer
        digitalWrite(ledPin, LOW);     // Turn off LED
    }

    delay(100); // Short delay for stability
}
