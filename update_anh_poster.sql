-- Script update anhPoster cho cac phim chua co anh
-- Chay trong Oracle SQL Developer
UPDATE RAPPHIM.PHIM 
SET ANH_POSTER = 'placeholder.svg' 
WHERE ANH_POSTER IS NULL OR TRIM(ANH_POSTER) = '';

COMMIT;

-- Kiem tra ket qua
SELECT MA_PHIM, TEN_PHIM, ANH_POSTER FROM RAPPHIM.PHIM ORDER BY MA_PHIM;
