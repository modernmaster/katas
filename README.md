# Katas
[![Build Status](https://travis-ci.org/modernmaster/katas.svg?branch=master)][travis]
[![Code Climate](https://codeclimate.com/github/modernmaster/katas/badges/gpa.svg)][codeclimate]
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/6bf45eaa847045a68d522379a8a66ed9)][codequality]
[![Coverity](https://scan.coverity.com/projects/8939/badge.svg)][coverity]
[![Code Coverage](https://codecov.io/gh/modernmaster/katas/branch/master/graph/badge.svg)][codecov]
[![Issue Count](https://codeclimate.com/github/modernmaster/katas/badges/issue_count.svg)][issues]
[![Sauce Test Status](https://saucelabs.com/buildstatus/modernmaster)][atstatus]
[![Sauce Coverage Matrix](https://saucelabs.com/browser-matrix/modernmaster.svg)][atstatuscoverage]
[![Throughput Graph](https://graphs.waffle.io/modernmaster/katas/throughput.svg)][waffle]
[![Stories in Ready](https://badge.waffle.io/modernmaster/katas.png?label=ready&title=Ready)][stories]
[![Download Latest Version](https://api.bintray.com/packages/modernmaster/maven/katas/images/download.svg)][download]

[travis]: http://travis-ci.org/modernmaster/katas
[codeclimate]: https://codeclimate.com/github/modernmaster/katas
[issues]: https://codeclimate.com/github/modernmaster/katas
[stories]: https://waffle.io/modernmaster/katas
[coverity]: https://scan.coverity.com/projects/modernmaster-katas
[codequality]: https://www.codacy.com/app/James-McGuiganOrganization/katas?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=modernmaster/katas&amp;utm_campaign=Badge_Grade
[codecov]: https://codecov.io/gh/modernmaster/katas
[atstatus]: https://saucelabs.com/u/modernmaster
[atstatuscoverage]: https://saucelabs.com/u/modernmaster
[download]: https://bintray.com/modernmaster/maven/katas/_latestVersion

[waffle]: https://waffle.io/modernmaster/katas/metrics/throughput
[Website](http://www.jamesmcguigan.co.uk/) | [Wiki](https://github.com/modernmaster/katas/wiki)

A selection of kata implementations that demonstrate awesomeness.

## Features

-- TBD

## Installation

-- TBD

## Contents

* [1. Katas] (#1-katas)
    * [1.1 Fizz Buzz](#11-fizz-buzz)
        * [1.1.1 Problem Description](#111-problem-description)
        * [1.1.2 Expected Output](#112-expected-output)
    * [1.2 Potter](#12-potter)
        * [1.2.1 Problem Description](#111-problem-description)
        * [1.2.2 Expected Output](#112-expected-output)
    * [1.3 Trains](#13-trains)
        * [1.3.1 Problem Description](#111-problem-description)
        * [1.3.2 Expected Output](#112-expected-output)
    * [1.4 Rock Paper Scissors](#14-rock-paper-scissors)
* [2. Testing] (#2-testing)
* [3. Development] (#3-development)
* [4. Contributing] (#4-contributing)
* [5. Copyright] (#4-copyright)

## 1 Katas

### 1.1 Fizz Buzz

#### 1.1.1 Problem Description

Imagine the scene. You are eleven years old, and in the five minutes before the end of the lesson, your Maths teacher decides he should make his class more "fun" by introducing a "game". He explains that he is going to point at each pupil in turn and ask them to say the next number in sequence, starting from one. The "fun" part is that if the number is divisible by three, you instead say "Fizz" and if it is divisible by five you say "Buzz". So now your maths teacher is pointing at all of your classmates in turn, and they happily shout "one!", "two!", "Fizz!", "four!", "Buzz!"... until he very deliberately points at you, fixing you with a steely gaze... time stands still, your mouth dries up, your palms become sweatier and sweatier until you finally manage to croak "Fizz!". Doom is avoided, and the pointing finger moves on.

So of course in order to avoid embarassment infront of your whole class, you have to get the full list printed out so you know what to say. Your class has about 33 pupils and he might go round three times before the bell rings for breaktime. Next maths lesson is on Thursday. Get coding!

Write a program that prints the numbers from 1 to 100. But for multiples of three print "Fizz" instead of the number and for the multiples of five print "Buzz". For numbers which are multiples of both three and five print "FizzBuzz?".

#### 1.1.2 Expected Output

  1
  2
  Fizz
  4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
16
17
Fizz
19
Buzz
... etc up to 100
Stage 2 - new requirements

 * A number is fizz if it is divisible by 3 or if it has a 3 in it
 * A number is buzz if it is divisible by 5 or if it has a 5 in it

### 1.2 Potter

#### 1.2.1 Problem Description

Once upon a time there was a series of 5 books about a very English hero called Harry. (At least when this Kata was invented, there were only 5. Since then they have multiplied) Children all over the world thought he was fantastic, and, of course, so did the publisher. So in a gesture of immense generosity to mankind, (and to increase sales) they set up the following pricing model to take advantage of Harry's magical powers.

One copy of any of the five books costs 8 EUR. If, however, you buy two different books from the series, you get a 5% discount on those two books. If you buy 3 different books, you get a 10% discount. With 4 different books, you get a 20% discount. If you go the whole hog, and buy all 5, you get a huge 25% discount.

Note that if you buy, say, four books, of which 3 are different titles, you get a 10% discount on the 3 that form part of a set, but the fourth book still costs 8 EUR.

Potter mania is sweeping the country and parents of teenagers everywhere are queueing up with shopping baskets overflowing with Potter books. Your mission is to write a piece of code to calculate the price of any conceivable shopping basket, giving as big a discount as possible.

#### 1.2.2 Expected Output

For example, how much does this basket of books cost?

  2 copies of the first book
  2 copies of the second book
  2 copies of the third book
  1 copy of the fourth book
  1 copy of the fifth book
(answer: 51.20 EUR)

### 1.3 Trains - Best route

#### 1.3.1 Problem Description

The local commuter railroad services a number of towns in Kiwiland.  Because of monetary concerns, all of the tracks are 'one-way.'  That is, a route from Kaitaia to Invercargill does not imply the existence of a route from Invercargill to Kaitaia.  In fact, even if both of these routes do happen to exist, they are distinct and are not necessarily the same distance!

The purpose of this problem is to help the railroad provide its customers with information about the routes.  In particular, you will compute the distance along a certain route, the number of different routes between two towns, and the shortest route between two towns.

Input:  A directed graph where a node represents a town and an edge represents a route between two towns.  The weighting of the edge represents the distance between the two towns.  A given route will never appear more than once, and for a given route, the starting and ending town will not be the same town.

Output: For test input 1 through 5, if no such route exists, output 'NO SUCH ROUTE'.  Otherwise, follow the route as given; do not make any extra stops!  For example, the first problem means to start at city A, then travel directly to city B (a distance of 5), then directly to city C (a distance of 4).
The distance of the route A-B-C.
The distance of the route A-D.
The distance of the route A-D-C.
The distance of the route A-E-B-C-D.
The distance of the route A-E-D.
The number of trips starting at C and ending at C with a maximum of 3 stops.  In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).
The number of trips starting at A and ending at C with exactly 4 stops.  In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).
The length of the shortest route (in terms of distance to travel) from A to C.
The length of the shortest route (in terms of distance to travel) from B to B.
The number of different routes from C to C with a distance of less than 30.  In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.

#### 1.3.2 Expected Output

For the test input, the towns are named using the first few letters of the alphabet from A to D.  A route between two towns (A to B) with a distance of 5 is represented as AB5.
Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
Expected Output:
Output #1: 9
Output #2: 5
Output #3: 13
Output #4: 22
Output #5: NO SUCH ROUTE
Output #6: 2
Output #7: 3
Output #8: 9
Output #9: 9
Output #10: 7

### 1.4 Rock Paper Scissors

#### 1.4.1 Problem Description

+--------------------------------------------------+

|                                                  |

|     Title: Waste an Hour Having Fun              |

|                                                  |

| As a frequent games player,                      |

| I'd like to play rock, paper, scissors           |

| so that I can spend an hour of my day having fun |

|                                                  |

| Acceptance Criteria                              |

|  - Can I play Player vs Computer?                |

|  - Can I play Computer vs Computer?              |

|  - Can I play a different game each time?        |

|                                                  |

|                                                  |

+--------------------------------------------------+

### 1.4 GS - Longest word

Given a string of letters and a dictionary, the function longestWord should find the longest word or words in the dictionary that can be made from the given letters
*     Input: letters = "oet", dictionary = {"to","toe","toes"}
*     Output: {"toe"}

### 1.5 GS - Double ended queue

Implement a double-ended queue (abbreviated to deque) that stores strings.  A deque is a data structure that has characteristics of both a queue and a stack. Elements can be added or removed from either the front or back.

### 1.6 G - Election

At any time during an election, write a solution that will find who is currently winning.

## 2 Testing

-- TBD

Security scanned using https://status.srcclr.net/

## 3 Development

Questions or problems? Please post them on the [issue tracker](https://waffle.io/modernmaster/katas). You can contribute changes by forking the project and submitting a pull request.

## 4 Contributing

Bug reports and pull requests are welcome on GitHub at https://github.com/modernmaster/katas. This project is intended to be a safe, welcoming space for collaboration, and contributors are expected to adhere to the [Contributor Covenant](http://contributor-covenant.org) code of conduct.

## 5 Copyright

Copyright (c) 2012-2016 James McGuigan.  See LICENSE for further details.
