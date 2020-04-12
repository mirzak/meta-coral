FILESEXTRAPATHS_prepend_coral-dev := "${THISDIR}/${PN}-${PV}:"

# Patches from https://coral.googlesource.com/imx-gst-plugins-bad
#
# Generated using:
#
#    git format-patch rel_imx_4.14.98_2.0.0_ga..1.14.4+imx-7
#
# Patches that update include paths are excluded
SRC_URI_append_coral-dev = " \
    file://0001-kmssink-fix-bad-property-memory-management.patch \
    file://0002-Fix-wayland-display-context-field-name.patch \
    file://0004-Quiet-down-a-noisy-print.patch \
    file://0005-Revert-MMFMWK-7954-waylandsink-default-to-play-video.patch \
    file://0006-waylandsink-properly-implement-full-screen-wayland-s.patch \
"
