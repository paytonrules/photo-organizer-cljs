(ns photo-organizer
  (:require [domina :as dom]
            [domina.css :as css]
            [goog.net.XhrIo :as xhr]
            [domina.events :as ev]))

(defn- directories-from [response]
  ("directories" (js->clj (.getResponseJson response))))

(defn- directories-as-html [directories] 
  (clojure.string/join 
    "" (map (fn [directory] 
           (str "<p><a href='" 
                directory 
                "'>" 
                directory 
                "</a></p>"))
         directories)))

(defn- receiver [event] 
  (let [response (.-target event)]
    (js/console.log (directories-as-html (directories-from response)))
    (dom/append! 
      (css/sel "#directories") 
      (directories-as-html (directories-from response)))))

(defn init []
  (xhr/send "directories" receiver "GET"))

(set! (.-onload js/window) init)
