(defproject photo-organizer-cljs "0.1.0-SNAPSHOT"
  :description "My Single Page App Photo Organizer"
  :url "http://www.paytonrules.com"
  :source-paths ["src/clj"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/google-closure-library-third-party "0.0-2029"]
                 [domina "1.0.2-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "0.3.0"]]

  :cljsbuild {:builds
              [{
                :source-paths ["src/cljs"]

                :compiler {
                           :output-to "resources/public/js/photo-organizer.js"

                           :optimizations :whitespace

                           :pretty-print true}}]})
