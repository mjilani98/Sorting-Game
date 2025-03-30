*Overview

  -This is an interactive sorting game where users must sort an array of numbers using a sliding window mechanism. The application is designed using the Model-View-Controller (MVC) architecture to ensure a structured and maintainable codebase.

*Features

  -A vertical one-dimensional array containing 10 random numbers between 1 and 100.

  -A sliding window that covers two adjacent slots with a distinct background color.

  -The window starts at a randomly selected position.

  -Users can slide the window down by one slot with a single tap.

  -The window wraps around to the top when it reaches the bottom of the array.

  -Users can swap the two numbers inside the window using a double tap.

  -The goal is to sort the array in ascending order within 45 swaps.

  -The user wins if they complete the sorting in 45 swaps or less; otherwise, they lose.

  -The remaining swap count is displayed below the array.

  -The win/loss message is displayed at the end.

  -Single and double taps are disabled when the game ends.

  -Designed with a user-friendly interface and clear visual distinctions.

*How to Play

  -Start the game, and a random array of numbers will be displayed.

  -A sliding window will highlight two adjacent numbers.

  -Single Tap: Move the sliding window down by one position (wraps around at the end).

  -Double Tap: Swap the two numbers inside the window.

  -Repeat the process until the array is sorted in ascending order.

  -The game tracks the number of swaps, and the user must sort the array in 45 swaps or fewer to win.

  -Once the game is complete, it will display a win/loss message and disable interactions.

*Technologies Used

  -Programming Language: Java

  -UI Design: XML (Android Layouts)

  -Architecture: Model-View-Controller (MVC)

  -Development Environment: Android Studio
