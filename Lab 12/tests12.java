//  INTY SORTY DRIVER. Test INTY SORTY LIST. The comments show what is printed.
//  Numbers at the ends of some comments show how many points a test is worth,
//  for a total of 30 points.

class IntySortyDriver
{

//  MAIN. Run the tests.

  public static void main(String [] args)
  {

//  Sort an empty list.

    IntySortyList empty = new IntySortyList();
    System.out.println(empty);                       //  []
    empty.sort();
    System.out.println(empty);                       //  []                  5.

//  Sort a list with one element.

    IntySortyList one = new IntySortyList(1);
    System.out.println(one);                         //  [1]
    one.sort();
    System.out.println(one);                         //  [1]                 5.

//  Sort a list with two elements.

    IntySortyList two = new IntySortyList(2, 1);
    System.out.println(two);                         //  [2, 1]
    two.sort();
    System.out.println(two);                         //  [1, 2]              5.

//  Sort a list with random non-negative elements.

    IntySortyList positives = new IntySortyList(5, 2, 1, 3, 4);
    System.out.println(positives);                   //  [5, 2, 1, 3, 4]
    positives.sort();
    System.out.println(positives);                   //  [1, 2, 3, 4, 5]     5.

//  Sort a list with duplicate non-negative elements.

    IntySortyList duplicates = new IntySortyList(3, 2, 1, 2, 3);
    System.out.println(duplicates);                  //  [3, 2, 1, 2, 3]
    duplicates.sort();
    System.out.println(duplicates);                  //  [1, 2, 2, 3, 3]     5.

//  The big finish. Sort a list with negative and non-negative elements.

    IntySortyList finish = new IntySortyList(2, -1, 0, -2, 1);
    System.out.println(finish);                      //  [2, -1, 0, -2, 1]
    finish.sort();
    System.out.println(finish);                      //  [-2, -1, 0, 1, 2]   5.
  }
}
