(ns week2.test-collections
  (:use midje.sweet
        week2.collections))

(fact "doublificate"
      (doublificate {"a" 1 "b" 7}) => {"a" 1, "double-a" 2
                                       "b" 7 "double-b" 14})

(facts "halve"
       (halve [1 2 3 4])   => (just (just 1 2) (just 3 4))
       (halve [1 2 3 4 5]) => (just (just 1 2 3) (just 4 5)))

(facts "first-five-positives"
       (first-five-positives [1 3 -2 3 2 0 10 -1 42]) => (just 1 3 3 2 10)
       (first-five-positives [1 -2 9 -4 -5])          => (just 1 9))

(fact "snip"
      (snip [1 4 2 :snip 8 2 9]) => (just (just 1 4 2) (just 8 2 9)))

(facts "monotonic?"
       (monotonic? [1 2 3])   => truthy
       (monotonic? [3 2 1 0]) => truthy
       (monotonic? [3 2 2])   => truthy
       (monotonic? [1 2 1 0]) => falsey)

(facts "take-3"
       (take-3 [1 2 3 4 5]) => [1 2 3]
       (take-3 ["Haruki" "Murakami"]) => ["Haruki" "Murakami" nil])

(facts "author-to-string"
       (author-to-string {:name "Shakespeare, William"
                          :birth-year 1564, :death-year 1616})
           => "Shakespeare, William (1564-1616)"
       (author-to-string {:name "Doyle, Arthur Conan, Sir"
                          :birth-year 1859, :death-year 1930})
           => "Doyle, Arthur Conan, Sir (1859-1930)")


(fact "book-to-string"
      (book-to-string {:title "Nuoren Robertin matka Grönlantiin isäänsä hakemaan"
                       :author {:name "Hoffmann, Franz"
                                :birth-year 1814, :death-year 1882}})
          => "A book, Nuoren Robertin matka Grönlantiin isäänsä hakemaan, written by Hoffmann, Franz (1814-1882)")
